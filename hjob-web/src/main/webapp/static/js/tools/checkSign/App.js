/**
 * @author wjc133
 */
define({
    template:
    '<div>' +
    '<i-button @click="show">Click me!</i-button>' +
    '<Modal v-model="visible" title="Welcome">Welcome to WDDS</Modal>' +
    '</div>',
    data: function () {
        return {
            visible: false
        }
    },
    methods: {
        show: function () {
            this.visible = true;
        }
    }
});