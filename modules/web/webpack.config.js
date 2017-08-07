var path = require('path');
var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var HtmlWebpackPlugin = require('html-webpack-plugin');

const node_dir = __dirname + '/node_modules';

var config = {
  entry: {
    'index': './src/index.js',
    "vendors": ['react', 'react-dom', 'jquery', 'tether', 'bootstrap']
  },

  output: {               //打包后的文件
    path: __dirname + '/public/assert/',   //表示使用绝对路径
    filename: '[name].js' //输出文件名
  },
  module: {
    rules: [            //用于加载一些静态文件夹（css样式，图片之类）
      {
        test: /\.(css|less)$/, use: ExtractTextPlugin.extract({
        fallback: "style-loader",
        use: "css-loader"
      })
      },
      {
        test: /\.js?$/,
        include: [
          path.resolve(__dirname, '/src')
        ],
        loader: "babel-loader",
        query: {
          presets: ['react', 'es2015']
        }
      },
      {
        test: /\.jsx?$/,
        loader: 'babel-loader',
        exclude: /node_modules/, //不进行转换的文件，可以提高打包速度
        query: {
          presets: ['react', 'es2015']
        }
      },


      {
        test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
        use: 'url-loader?limit=10000&minetype=application/font-woff'
      },
      {
        test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
        use: 'file-loader'
      },
      {
        test: /\.(png|jpg|gif)$/,
        use: 'url-loader?limit=10000&name=/build/[name].[ext]'
      }
    ]
  },
  plugins: [
    new webpack.optimize.CommonsChunkPlugin({
      name: 'vendors',
      filename: 'vendors.js'
    }),
    new ExtractTextPlugin('[chunkhash:8].[name].css'),
    new HtmlWebpackPlugin({
      filename: 'index.html',
      minify: {collapseWhitespace: true},
      template: path.join(__dirname, '/public', 'index.html'),
      inject: true,
      chunks: ['index', 'vendors']
    }),
    new webpack.ProvidePlugin({
      $: "jquery",
      jQuery: "jquery",
      "Tether": 'tether',
      "window.jQuery": "jquery",
      "window.Tether": 'tether'
    })
  ],
  resolve: {
    alias: {
      'jquery': node_dir + '/jquery/dist/jquery.js',
      'tether': node_dir + '/tether/dist/js/tether.min.js',
      'bootstrap': node_dir + '/bootstrap/dist/js/bootstrap.min.js'
    }
  }
};


module.exports = config;
