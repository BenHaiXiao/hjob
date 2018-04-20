/**
 * @author wjc133
 */
var gridColumns = [
    {
        id: 'uid',
        title: 'UID',
        type: 'number',
        columnClass: 'text-center'
    },
    {
        id: 'sid',
        title: '频道号',
        type: 'number',
        columnClass: 'text-center'
    },
    {
        id: 'ssid',
        title: '子频道号',
        type: 'number',
        columnClass: 'text-center'
    },
    {
        id: 'title',
        title: '开播标题',
        type: 'string',
        columnClass: 'text-center'
    },
    {
        id: 'stopType',
        title: '停播类型',
        type: 'string',
        columnClass: 'text-center',
        resolution: function (value, record, column, grid, dataNo, columnNo) {
            var content = '';
            var valid = parseInt(value);
            if (valid == 1) {
                content = "<label class='label label-info'>主动停播</label>"
            } else if (valid == 2) {
                content = "<label class='label label-warning'>心跳丢失</label>"
            }
            return content;
        }
    },
    {
        id: 'startTime',
        title: '开播时间',
        type: 'date',
        format: 'yyyy-MM-dd hh:mm:ss',
        otype: 'time_stamp_ms',
        columnClass: 'text-center'
    },
    {
        id: 'startTime',
        title: '停播时间',
        type: 'date',
        format: 'yyyy-MM-dd hh:mm:ss',
        otype: 'time_stamp_ms',
        columnClass: 'text-center'
    },
    {
        id: 'heartbeatTime',
        title: '最后心跳时间',
        type: 'date',
        format: 'yyyy-MM-dd hh:mm:ss',
        otype: 'time_stamp_ms',
        columnClass: 'text-center'
    },
    {
        id: 'platform',
        title: '开播平台',
        type: 'string',
        columnClass: 'text-center',
        resolution: function (value, record, column, grid, dataNo, columnNo) {
            var content = '';
            var valid = parseInt(value);
            if (valid == 1) {
                content = "Android"
            } else if (valid == 2) {
                content = "iOS"
            } else if (valid == 3) {
                content = "WP";
            } else if (valid == 4) {
                content = "其他";
            } else {
                content = "未知";
            }
            return content;
        }
    },
    {
        id: 'operation',
        title: '操作',
        type: 'string',
        columnClass: 'text-center', resolution: function (value, record, column, grid, dataNo, columnNo) {
        var content = '';
        content += '<button class="btn btn-xs btn-danger" onclick="commitRepair(' + record.id + ')"><i class="fa fa-check"></i> 补回开播列表</button>';
        return content;
    }
    }
];

function commitRepair(id) {
    parent.layer.confirm("你确定要将该条记录补回开播列表吗？", function () {
        $.ajax({
            url: "/tools/repair/living/" + id,
            method: "PUT",
            success: function (response) {
                if (response && response.code === 200) {
                    window.layer.alert("修复成功");
                } else {
                    window.layer.alert("修复异常");
                }
            },
            error: function () {
                window.layer.alert("服务器错误");
            }
        });
    }, function () {

    });
}

var gridOption = {
    lang: 'zh-cn',
    ajaxLoad: true,
    loadURL: '/live/history/query',
    columns: gridColumns,
    gridContainer: 'gridContainer',
    toolbarContainer: 'gridToolBar',
    tools: '',
    pageSize: 200,
    pageSizeLimit: [50, 100, 200]
};

var grid = $.fn.dlshouwen.grid.init(gridOption);

$(function () {
    grid.parameters = {};
    grid.load();

    bindAction();
});

function bindAction() {
    $('#queryBtn').on('click', function () {
        grid.parameters = {};
        grid.parameters['uid'] = $('#queryUid').val();
        grid.refresh(true);
    });

    $('#resetBtn').on('click', function () {
        $('#queryUid').val("");
    })
}