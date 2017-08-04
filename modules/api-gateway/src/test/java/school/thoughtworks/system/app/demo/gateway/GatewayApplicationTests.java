package school.thoughtworks.system.app.demo.gateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GatewayApplicationTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void pre_filter_should_return_401_when_without_token() throws Exception {
        ResponseEntity<Integer> responseEntity = testRestTemplate.getForEntity("/api/service_a/compute?a=1&b=2",Integer.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void pre_filter_should_return_200_when_with_token() throws Exception {
        ResponseEntity<Integer> responseEntity = testRestTemplate.getForEntity("/api/service_a/compute?a=1&b=2&token=zhangpei",Integer.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(3);
    }


}
