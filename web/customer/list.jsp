<%--
  Created by IntelliJ IDEA.
  User: Mirai
  Date: 2018/4/13
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>客户列表</title>
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>客户列表</legend>
</fieldset>
<div class="demoTable" style="float: right;margin-right: 10%">
    搜索客户：
    <div class="layui-inline">
        <input name="cust_name" class="layui-input" id="custReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>
<br/>
<table id="customers" style="margin-top: 2%"></table>

<script src="../layui/layui.js"></script>
<script>
    var width = document.body.clientWidth;
    var height = document.body.clientHeight;
    var tableWidth = width-110/3
    layui.use('table', function () {
        var table = layui.table;

        //第一个实例
        var cusTabIn = table.render({
            elem: '#customers'
            , height: 300
            , width: width-200
            , url: '${pageContext.request.contextPath }/customer_findAllCustomer.action' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'cust_id', title: 'ID', width: '33%', sort: true, fixed: 'left'}
                , {field: 'cust_name', title: '客户名', width: '33%'}
                , {field: 'cust_level', title: '级别', width: '33%'}
            ]]
            , id: 'tableReload'
            , limit: 10
            , limits: [10,20]
        });

        var $ = layui.$, active = {
            reload: function () {
                var custReload = $('#custReload');

                //执行重载
                table.reload('tableReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        cust_name: custReload.val()
                    }
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });
</script>
</body>
</html>