<%--
  Created by IntelliJ IDEA.
  User: Mirai
  Date: 2018/4/13
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加客户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>添加客户</legend>
</fieldset>

<form class="layui-form" action="${pageContext.request.contextPath }/customer_save.action">
    <div class="layui-form-item">
        <label class="layui-form-label">客户姓名</label>
        <div class="layui-input-block">
            <input name="cust_name" class="layui-input" type="text" placeholder="请输入客户的姓名" autocomplete="off" lay-verify="cust_name">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">客户级别</label>
        <div class="layui-input-block">
            <input type="radio" name="cust_level" value="低级" title="低级">
            <input type="radio" name="cust_level" value="中级" title="中级" checked>
            <input type="radio" name="cust_level" value="高级" title="高级">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="submitcustomer">保存客户</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script src="../layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('form', function(){
        var form = layui.form;
        //自定义验证规则
        form.verify({
            cust_name: function(value){
                if(value.length < 1){
                    return '请输入姓名';
                }
            }
        });

    });
</script>

</body>
</html>