/**
 * @author wjc133
 */
require.config({
    baseUrl: "/static/js",
    paths: {
        'vue': 'common/vue',
        'iview': 'common/iview',
        'axios': 'common/axios.min',
        'App': 'tools/checkSign/App'
    }
});

require(['vue','iview','axios','App'], function (Vue,iView,axios,App) {
    Vue.use(iView)
    new Vue({
        el: '#app',
        template: '<App/>',
        components: {'App':App}
    })
});