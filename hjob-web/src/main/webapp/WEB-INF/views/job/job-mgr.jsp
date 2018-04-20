<%--
  Created by IntelliJ IDEA.
  User: Shildon
  Date: 2017/5/10
  Time: 16:05
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>任务管理</title>
    <link rel="stylesheet" href="${ctx}/static/css/dtgrid-reset.css">
    <link rel="stylesheet" href="${ctx}/static/css/plugins/remodal/remodal.css">
    <link rel="stylesheet" href="${ctx}/static/css/plugins/remodal/remodal-default-theme.css">
    <style type="text/css">
        .dlshouwen-grid-toolbar-container select {
            display: none;
        }
    </style>
</head>
<body>
<div class="row">
    <div class="col-sm-12">
        <div class="ibox float-e-margins">
            <div id="jobTabTitle" class="ibox-title">
                <h5>任务管理</h5>
            </div>
            <div id="jobAlertSuccess" class="alert alert-success alert-dismissible" style="margin-bottom: 0px; display: none" role="alert">
                <p id="jobAlertSuccessText" class="text-center">操作成功！</p>
            </div>
            <div id="jobAlertDanger" class="alert alert-danger alert-dismissible" style="margin-bottom: 0px; display: none" role="alert">
                <p id="jobAlertDangerText" class="text-center">操作失败！</p>
            </div>
            <div id="allJobsContainer" class="ibox-content">
                <div class="row">
                    <div class="col-sm-2">
                        <input id="searchJobGroup" type="text" placeholder="组" class="form-control">
                    </div>
                    <div class="col-sm-2">
                        <button id="jobAddBtn" type="button" class="btn btn-sm btn-danger" data-remodal-target="addModal">新增</button>
                        <button id="jobSearchBtn" type="button" class="btn btn-sm btn-primary">搜索</button>
                    </div>
                </div>

                <hr id="jobBegin" />
            </div>
        </div>
    </div>
</div>
<div class="remodal-bg">
    <div class="remodal" data-remodal-id="addModal">
        <button data-remodal-action="close" class="remodal-close"></button>
        <h3>新增任务</h3>
        <div class="hr-line-dashed"></div>
        <div class="col-sm-12">
            <form id="addJobForm" class="form-horizontal">
                <div class="form-group">
                    <label for="addJobName" class="col-sm-3 control-label">名称</label>
                    <div class="col-sm-7">
                        <input id="addJobName" name="addJobName" type="text"
                               class="form-control dialog-control required">
                    </div>
                </div>

                <div class="form-group">
                    <label for="addJobGroup" class="col-sm-3 control-label">组</label>
                    <div class="col-sm-7">
                        <input id="addJobGroup" name="addJobGroup" type="text"
                               class="form-control dialog-control required">
                    </div>
                </div>

                <div class="form-group">
                    <label for="addJobNotifyKey" class="col-sm-3 control-label">Key</label>
                    <div class="col-sm-7">
                        <input id="addJobNotifyKey" name="addJobNotifyKey" type="text"
                               class="form-control dialog-control required">
                    </div>
                </div>

                <div class="form-group">
                    <label for="addCronexpression" class="col-sm-3 control-label">表达式</label>
                    <div class="col-sm-7">
                        <input id="addCronexpression" name="addCronexpression" type="text"
                               class="form-control dialog-control required">
                    </div>
                </div>

                <div class="form-group">
                    <label for="addDescription" class="col-sm-3 control-label">描述</label>
                    <div class="col-sm-7">
                        <textarea id="addDescription" name="addDescription" rows="5"
                               class="form-control dialog-control required"></textarea>
                    </div>
                </div>

                <div class="hr-line-dashed"></div>
                <div class="form-group">
                    <button id="addJobSubmitBtn" data-remodal-action="confirm" class="remodal-confirm">提交</button>
                    <button data-remodal-action="cancel" class="remodal-cancel">取消</button>
                </div>
            </form>
        </div>
    </div>
    <div class="remodal" data-remodal-id="editModal">
        <button data-remodal-action="close" class="remodal-close"></button>
        <h3>修改任务</h3>
        <div class="hr-line-dashed"></div>
        <div class="col-sm-12">
            <form id="editJobForm" class="form-horizontal">
                <input id="editJobId" hidden="hidden">
                <fieldset disabled>
                    <div class="form-group">
                        <label for="editJobName" class="col-sm-3 control-label">名称</label>
                        <div class="col-sm-7">
                            <input id="editJobName" name="editJobName" type="text"
                                   class="form-control dialog-control required">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="editJobGroup" class="col-sm-3 control-label">组</label>
                        <div class="col-sm-7">
                            <input id="editJobGroup" name="editJobGroup" type="text"
                                   class="form-control dialog-control required">
                        </div>
                    </div>
                </fieldset>

                <div class="form-group">
                    <label for="editCronexpression" class="col-sm-3 control-label">表达式</label>
                    <div class="col-sm-7">
                        <input id="editCronexpression" name="editCronexpression" type="text"
                               class="form-control dialog-control required">
                    </div>
                </div>

                <div class="form-group">
                    <label for="editDescription" class="col-sm-3 control-label">描述</label>
                    <div class="col-sm-7">
                        <textarea id="editDescription" name="editDescription" rows="5"
                                  class="form-control dialog-control required"></textarea>
                    </div>
                </div>

                <div class="hr-line-dashed"></div>
                <div class="form-group">
                    <button id="editJobSubmitBtn" data-remodal-action="confirm" class="remodal-confirm">提交</button>
                    <button data-remodal-action="cancel" class="remodal-cancel">取消</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="${ctx}/static/js/job/job-mgr.js?t=201801121810" type="text/javascript"></script>
<script src="${ctx}/static/js/plugins/remodal/remodal.min.js" type="text/javascript"></script>
</body>
</html>
