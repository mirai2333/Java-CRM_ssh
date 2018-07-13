<%--
  Created by IntelliJ IDEA.
  User: Mirai
  Date: 2018/4/14
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>联系人列表</title>
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>联系人列表</legend>
</fieldset>
<div class="demoTable" style="float: right;margin-right: 10%">
    搜索联系人：
    <div class="layui-inline">
        <input name="lkmName" class="layui-input" id="lkmReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">筛选</button>
</div>
<br/>
<table id="linkmans" style="margin-top: 2%"></table>

<script src="../layui/layui.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;

        //第一个实例
        var cusTabIn = table.render({
            elem: '#linkmans'
            , height: 500
            , url: '${pageContext.request.contextPath }/linkman_findAllLinkman' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'lkmId', title: 'ID', width: '25%', sort: true, fixed: 'left'}
                , {field: 'lkmName', title: '姓名', width: '25%'}
                , {field: 'lkmSex', title: '性别', width: '25%'}
                , {field: 'lkmPhone', title: '固定电话', width: '25%'}
                , {field: 'lkmMobile', title: '手机', width: '25%'}
            ]]
            , id: 'tableReload'
        });

        var $ = layui.$, active = {
            reload: function () {
                var lkmReload = $('#lkmReload');

                //执行重载
                table.reload('tableReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        lkmName: lkmReload.val()
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