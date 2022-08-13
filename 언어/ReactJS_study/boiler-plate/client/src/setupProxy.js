const { createProxyMiddleware } = require('http-proxy-middleware');

//front에서 줄때 , target을 5000으로 주겠다는 설정
module.exports = function(app) {
  app.use(
    '/api',
    createProxyMiddleware({
      target: 'http://localhost:5000',
      changeOrigin: true,
    })
  );
};