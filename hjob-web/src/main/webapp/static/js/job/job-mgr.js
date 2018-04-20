/**
 * @author xiaobenhai
 */
var gridColumns = [
    {
        id: 'jobName',
        title: '名称',
        type: 'string',
        columnClass: 'text-center',
        fastQuery: true,
        fastQueryType: 'lk'
    },
    {
        id: 'jobGroup',
        title: '组',
        type: 'string',
        columnClass: 'text-center',
        fastQuery: true,
        fastQueryType: 'lk'
    },
    {
        id: 'mqKey',
        title: 'mq的key',
        type: 'string',
        columnClass: 'text-center'
    },
    {
        id: 'jobDetailStatus',
        title: '任务细节状态',
        type: 'string',
        columnClass: 'text-center'
    },
    {
        id: 'jobStatus',
        title: '任务状态',
        type: 'string',
        columnClass: 'text-center',
        resolution: function (value, record, column, grid, dataNo, columnNo) {
            var content = '';
            var valid = parseInt(value);
            if (valid == 1) {
                content = "<span class='label label-primary'>可用</span>"
            } else if (valid == 2) {
                content = "<span class='label label-danger'>不可用</span>"
            }
            return content;
        }
    },
    {
        id: 'cronexpression',
        title: '表达式',
        type: 'string',
        columnClass: 'text-center'
    },
    {
        id: 'description',
        title: '描述',
        type: 'string',
        columnClass: 'text-center'
    },
    {
        id: 'operation',
        title: '操作',
        type: 'string',
        columnClass: 'text-center',
        resolution: function (value, record, column, grid, dataNo, columnNo) {
            var content = '';
            content += '<a data-remodal-target="editModal" class="btn btn-xs btn-info" onclick="editJob(\'' + record.jobId + '\',\'' + record.jobName + '\',\'' + record.jobGroup + '\',\'' + record.cronexpression + '\',\'' + record.description + '\')"><i class="fa fa-edit"></i> 编辑</a>';
            if (record.jobStatus == 1) {
                content += '  ';
                content += '<button class="btn btn-xs btn-danger" onclick="pauseJob(\'' + record.jobName + '\',\'' + record.jobGroup + '\')"><i class="fa fa-pause"></i>暂停</button>';
            }
            content += '  ';
            content += '<button class="btn btn-xs btn-primary" onclick="resumeJob(\'' + record.jobName + '\',\'' + record.jobGroup + '\')"><i class="fa fa-play"></i>恢复</button>';
            content += '  ';
            content += '<button class="btn btn-xs btn-default" onclick="deleteJob(\'' + record.jobName + '\',\'' + record.jobGroup + '\')"><i class="fa fa-times"></i>删除</button>';
            content += '  ';
            content += '<button class="btn btn-xs btn-success" onclick="getTime(\'' + record.jobName + '\',\'' + record.jobGroup + '\')">查看执行时间</button>';
            return content;
        }
    }
];

var gridMap = {};

$(function () {
    initToast();
    init();
    bindAction();
});

function initToast() {
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "progressBar": true,
        "positionClass": "toast-top-center",
        "onclick": null,
        "showDuration": "400",
        "hideDuration": "1000",
        "timeOut": "60000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };
}

function init() {
    $.ajax({
        url: '/job/groups',
        type: 'get',
        dataType: 'json',
        success: function (result) {
            if (result.code == 0) {
                var groups = result.data;
                initGroups(groups);
            }
        }
    });
}

function initGroups(groups) {
    var allJobsContainer = $('#allJobsContainer');
    // 初始操作
    $('#jobBegin').nextAll().remove();
    gridMap = {};

    groups.forEach(function (val, idx, array) {
        var jobGridId = 'jobGridId-' + idx;
        var jobToolBarId = 'jobToolBarId-' + idx;

        var jobContainer = wrapLabel(val);
        jobContainer += '<br/><br/>';
        jobContainer += '<div class="row"><div class="col-sm-12"><div id="' + jobGridId +
            '" class="dlshouwen-grid-container"></div><div id="' + jobToolBarId +
            '" class="dlshouwen-grid-toolbar-container"></div></div></div>';
        jobContainer += '<hr/>';
        allJobsContainer.append(jobContainer);

        var gridOption = {
            lang: 'zh-cn',
            ajaxLoad: true,
            loadURL: '/job/query',
            columns: gridColumns,
            gridContainer: jobGridId,
            toolbarContainer: jobToolBarId,
            tools: '',
            pageSize: 100,
            pageSizeLimit: [50, 100, 200]
        };
        var grid = $.fn.dlshouwen.grid.init(gridOption);
        grid.parameters = {
            jobGroup: val
        };
        grid.load();
        gridMap[val] = grid;
    })
}

function wrapLabel(content) {
    return '<span class="label label-default" style="font-size: 14px; margin-right: 3px">' + content + '</span>';
}

function bindAction() {
    $('#jobSearchBtn').on('click', function () {
        var group = $('#searchJobGroup').val();
        if (group == null || group == '' || group == undefined) {
            init();
        } else {
            var groups = [];
            groups.push($('#searchJobGroup').val());
            initGroups(groups);
        }
    });

    $('#jobResetBtn').on('click', function () {
        $('#searchJobGroup').val('');
    });

    $('.remodal').on('confirmation', function () {
        if ($('#editJobId').text() != '') {
            $.ajax({
                url: '/job/update',
                type: 'post',
                data: {
                    jobName: $('#editJobName').val(),
                    jobGroup: $('#editJobGroup').val(),
                    cronexpression: $('#editCronexpression').val(),
                    description: $('#editDescription').val()
                },
                dataType: 'json',
                success: function (result) {
                    if (result.success) {
                        location.reload(true);
                        showAlertSuccess('更新成功')
                    } else {
                        showAlertDanger('更新失败');
                    }
                }
            });
        } else {
            $.ajax({
                url: '/job/create',
                type: 'post',
                data: {
                    jobName: $('#addJobName').val(),
                    jobGroup: $('#addJobGroup').val(),
                    jobNotifyKey: $('#addJobNotifyKey').val(),
                    cronexpression: $('#addCronexpression').val(),
                    description: $('#addDescription').val()
                },
                dataType: 'json',
                success: function (result) {
                    if (result.success) {
                        $('#addJobName').val('');
                        $('#addJobGroup').val('');
                        $('#addJobNotifyKey').val('');
                        $('#addCronexpression').val('');
                        $('#addDescription').val('');
                        location.reload(true);
                        showAlertSuccess('新增成功')
                    } else {
                        showAlertDanger('新增失败');
                    }
                }
            });
        }
    });
}

function editJob(jobId, jobName, jobGroup, cronexpression, description) {
    $('#editJobId').text(jobId);
    $('#editJobName').val(jobName);
    $('#editJobGroup').val(jobGroup);
    $('#editCronexpression').val(cronexpression);
    $('#editDescription').val(description);
}

function deleteJob(jobName, jobGroup) {
    $.ajax({
        url: '/job/delete',
        type: 'get',
        data: {
            jobName: jobName,
            jobGroup: jobGroup
        },
        dataType: 'json',
        success: function (result) {
            if (result.success) {
                location.reload(true);
                showAlertSuccess("删除成功");
            } else {
                showAlertDanger("删除失败");
            }
        }
    })
}

function getTime(jobName, jobGroup) {
    $.ajax({
        url: '/job/time',
        type: 'get',
        data: {
            jobName: jobName,
            jobGroup: jobGroup
        },
        dataType: 'json',
        success: function (result) {
            toastr.info("上次执行时间：" + result.data.previousTime + " 下次执行时间：" + result.data.nextTime);
        }
    })
}

function pauseJob(jobName, jobGroup) {
    $.ajax({
        url: '/job/pause',
        type: 'get',
        data: {
            jobName: jobName,
            jobGroup: jobGroup
        },
        dataType: 'json',
        success: function (result) {
            if (result.success) {
                location.reload(true);
                showAlertSuccess('暂停成功');
            } else {
                showAlertDanger('暂停失败');
            }
        }
    })
}

function resumeJob(jobName, jobGroup) {
    $.ajax({
        url: '/job/resume',
        type: 'get',
        data: {
            jobName: jobName,
            jobGroup: jobGroup
        },
        dataType: 'json',
        success: function (result) {
            if (result.success) {
                location.reload(true);
                showAlertSuccess('恢复成功');
            } else {
                showAlertDanger('恢复失败')
            }
        }
    })
}

function showAlertSuccess(content) {
    $('#jobAlertSuccess').css('display', 'block');
    $('#jobAlertSuccessText').html(content);
    setTimeout(hideAlertSuccess, 3000);
}

function hideAlertSuccess() {
    $('#jobAlertSuccess').css('display', 'none');
}

function showAlertDanger(content) {
    $('#jobAlertDanger').css('display', 'block');
    $('#jobAlertDangerText').html(content);
    setTimeout(hideAlertDanger, 3000);
}

function hideAlertDanger() {
    $('#jobAlertDanger').css('display', 'none');
}
