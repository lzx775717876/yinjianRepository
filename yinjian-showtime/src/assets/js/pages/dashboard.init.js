/*
Template Name: Nazox - Responsive Bootstrap 4 Admin Dashboard
Author: Themesdesign
Contact: themesdesign.in@gmail.com
File: Dashboard Init Js File
*/

// Line-column chart

$(document).ready(function() {
    var dashBoardVue = new Vue({
        el: '#kejinDashBoard',
        data: {
            hehe: false,
            kejinList: [],
            allMoney: 0,
            allVirtual: 0,
            allReality: 0
        },
        methods: {
            calculateAll() {
                let length = this.kejinList.length;
                let allMoney = 0;
                let allVirtual = 0;
                for (let i = 0; i < length; i++) {
                    allMoney += Number(this.kejinList[i].money);
                    if (this.kejinList[i].type == 0) {
                        allVirtual += Number(this.kejinList[i].money);
                    }
                }
                this.allMoney = allMoney;
                this.allVirtual = allVirtual;
                this.allReality = allMoney - allVirtual;
                console.log(this.allMoney);
            },
        },
        mounted() {
            init();
            this.calculateAll();
        },
        created() {
            let thisPage = this;
            $.ajax({
                url: 'http://localhost:8080/buy/selectPage?pageIndex=1&pageSize=10000',
                type: "GET",
                async: false,
                contentType: "text",
                success: function(result) {
                    console.log(result.data.records);
                    thisPage.kejinList = result.data.records;
                },
                error: function(xMLHttpRequest, textStatus, errorThrown) {
                }
            });
        }
    })

});

function init() {
    var options = {
        series: [
            {
                name: "虚拟",
                type: "column",
                data: [80345, 35865, 6989, 16895]
            },
            {
                name: "实体",
                type: "column",
                data: [13258, 68982, 6878, 4589]
            }
        ],
        chart: {height: 280, type: "line", toolbar: {show: !1}},
        stroke: {width: [0, 0], curve: "smooth"},
        plotOptions: {bar: {horizontal: !1, columnWidth: "60%"}},
        dataLabels: {enabled: !1},
        legend: {show: !1},
        colors: ["#5664d2", "#1cbb8c"],
        labels: ['洪哥', "路西", "拓哥", "阿鸡"]
    }, chart = new ApexCharts(document.querySelector("#line-column-chart"), options);
    chart.render();

    // donut chart

    var options = {
        series: [105431, 113568, 13524, 19869],
        labels: ['洪哥', "路西", "拓哥", "阿鸡"],
        chartOptions: {
            labels: ['Apple', 'Mango', 'Orange', 'Watermelon']
        },
        chart: {
            type: 'donut'
            // type: 'pie'
        },
        dataLabels: {
            enabled: true,
            formatter: function (val) {
                return val.toFixed(1) + "%"
            }
        },
        plotOptions: {
            pie: {
                donut: {
                    size: '50%',
                    labels: {
                        show: true,
                        name: {
                            show: true
                        },
                        value: {
                            show: true
                        },
                        total: {
                            show: true,
                            label: '拢共',
                            color: 'black'
                        }
                    }
                }
            }
        }
    };

    var chart = new ApexCharts(document.querySelector("#donut-chart"), options);
    chart.render();


    // Radialchart 1

    var radialoptions = {
        series: [72],
        chart: {
            type: 'radialBar',
            wight: 60,
            height: 60,
            sparkline: {
                enabled: true
            }
        },
        dataLabels: {
            enabled: false
        },
        colors: ['#5664d2'],
        stroke: {
            lineCap: 'round'
        },
        plotOptions: {
            radialBar: {
                hollow: {
                    margin: 0,
                    size: '70%'
                },
                track: {
                    margin: 0,
                },

                dataLabels: {
                    show: false
                }
            }
        }
    };

    var radialchart = new ApexCharts(document.querySelector("#radialchart-1"), radialoptions);
    radialchart.render();


    // Radialchart 2

    var radialoptions = {
        series: [65],
        chart: {
            type: 'radialBar',
            wight: 60,
            height: 60,
            sparkline: {
                enabled: true
            }
        },
        dataLabels: {
            enabled: false
        },
        colors: ['#1cbb8c'],
        stroke: {
            lineCap: 'round'
        },
        plotOptions: {
            radialBar: {
                hollow: {
                    margin: 0,
                    size: '70%'
                },
                track: {
                    margin: 0,
                },

                dataLabels: {
                    show: false
                }
            }
        }
    };

    var radialchart = new ApexCharts(document.querySelector("#radialchart-2"), radialoptions);
    radialchart.render();

}