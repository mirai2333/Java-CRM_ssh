<%--
  Created by IntelliJ IDEA.
  User: Mirai
  Date: 2018/4/14
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加联系人</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>添加联系人</legend>
</fieldset>
<form class="layui-form" action="${pageContext.request.contextPath }/linkman_save.action">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">所属客户</label>
            <div class="layui-input-inline">
                <select name="cust_id" lay-search="" lay-verify="required">
                    <option value="">直接选择或搜索选择</option>
                    <c:forEach items="${list}" var="customer">
                        <option value="${customer.cust_id}">${customer.cust_id}--${customer.cust_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input name="lkmName" class="layui-input" type="text" placeholder="请输入联系人姓名" autocomplete="off"
                   lay-verify="title">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input name="lkmSex" title="男" type="radio" checked="" value="男">
            <input name="lkmSex" title="女" type="radio" value="女">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系手机</label>
        <div class="layui-input-inline">
            <input name="lkmMobile" class="layui-input" type="tel" autocomplete="off" lay-verify="required|phone">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">固定电话</label>
        <div class="layui-input-block">
            <input name="lkmPhone" class="layui-input" type="text" placeholder="请输入联系人的固定电话" autocomplete="off"
                   lay-verify="title">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-filter="demo1" lay-submit="">保存联系人</button>
            <button class="layui-btn layui-btn-primary" type="reset">重置</button>
        </div>
    </div>

</form>

<script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('form', function () {
        var form = layui.form;
        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 1) {
                    return '请输入联系人姓名';
                }
            }
        });

    });
</script>
</body>
</html>
