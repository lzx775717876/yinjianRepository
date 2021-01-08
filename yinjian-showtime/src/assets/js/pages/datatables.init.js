/*
Template Name: Nazox - Responsive Bootstrap 4 Admin Dashboard
Author: Themesdesign
Contact: themesdesign.in@gmail.com
File: Datatables Js File
*/

$(document).ready(function() {
    $.fn.dataTable.defaults.oLanguage = {
        "sProcessing": "处理中...",
        "sLengthMenu": "显示 _MENU_ 项结果",
        "sZeroRecords": "没有匹配结果",
        "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
        "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
        "sInfoPostFix": "",
        "sSearch": "搜索：",
        "sUrl": "",
        "sEmptyTable": "表中数据为空",
        "sLoadingRecords": "载入中...",
        "sInfoThousands": ",",
        "oPaginate": {
            "sFirst": "首页",
            "sPrevious": "上页",
            "sNext": "下页",
            "sLast": "末页"
        },
        "oAria": {
            "sSortAscending": ": 以升序排列此列",
            "sSortDescending": ": 以降序排列此列"
        }
    }
    //Buttons examples

    var kejinListVue = new Vue({
        el: '#kejinList',
        data: {
            hehe: false,
            kejinList: []
        },
        mounted() {
            var table = $('#datatable-buttons').DataTable({
                lengthChange: false,
                "language": {
                    "paginate": {
                        "previous": "<i class='mdi mdi-chevron-left'>",
                        "next": "<i class='mdi mdi-chevron-right'>"
                    }
                },
                "drawCallback": function () {
                    $('.dataTables_paginate > .pagination').addClass('pagination-rounded');
                },
                "order": []
                // buttons: ['copy', 'excel', 'pdf', 'colvis']
            });
        },
        created() {
            let thisPage = this;
            $.ajax({
                url: 'http://localhost:8080/buy/selectPage?pageIndex=1&pageSize=10000',
                type: "GET",
                async: false,
                contentType: "text",
                success: function(result) {
                    console.log(result.data.records)
                    thisPage.kejinList = result.data.records;
                },
                error: function(xMLHttpRequest, textStatus, errorThrown) {
                }
            });
        }
    })
    // table.buttons().container()
    //     .appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');

} );