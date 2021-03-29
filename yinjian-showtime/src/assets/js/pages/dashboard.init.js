/*
Template Name: Nazox - Responsive Bootstrap 4 Admin Dashboard
Author: Themesdesign
Contact: themesdesign.in@gmail.com
File: Dashboard Init Js File
*/

// Line-column chart

var dashBoardVue;

$(document).ready(function() {
    dashBoardVue = new Vue({
        el: '#kejinDashBoard',
        data: {
            hehe: false,
            kejinList: [],
            allMoney: 0,
            allVirtual: 0,
            allReality: 0,
            luxiVirtual: 0,
            honggeVirtual: 0,
            ajiVirtual: 0,
            tuogeVirtual: 0,
            luxiReality: 0,
            honggeReality: 0,
            ajiReality: 0,
            tuogeReality: 0,
            weekVirtual: 0,
            weekReality: 0
        },
        methods: {
            calculateAll() {
                let length = this.kejinList.length;
                let allMoney = 0, allVirtual = 0, luxiVirtual = 0, luxiReality = 0,
                    honggeVirtual = 0, honggeReality = 0, ajiVirtual = 0, ajiReality = 0,
                    tuogeVirtual = 0, tuogeReality = 0, weekVirtual = 0, weekReality = 0;
                let aWeekBefore = moment().add(-7, 'days');
                for (let i = 0; i < length; i++) {
                    allMoney += Number(this.kejinList[i].money);
                    if (this.kejinList[i].type == 0) {
                        allVirtual += Number(this.kejinList[i].money);
                        if (aWeekBefore <= moment(new Date(this.kejinList[i].createTime))) {
                            weekVirtual += Number(this.kejinList[i].money);
                        }
                    } else {
                        if (aWeekBefore <= moment(new Date(this.kejinList[i].createTime))) {
                            weekReality += Number(this.kejinList[i].money);
                        }
                    }
                    if (this.kejinList[i].userName == '路西') {
                        if (this.kejinList[i].type == 0){
                            luxiVirtual += Number(this.kejinList[i].money);
                        } else {
                            luxiReality += Number(this.kejinList[i].money);
                        }
                    }
                    if (this.kejinList[i].userName == '洪哥') {
                        if (this.kejinList[i].type == 0){
                            honggeVirtual += Number(this.kejinList[i].money);
                        } else {
                            honggeReality += Number(this.kejinList[i].money);
                        }
                    }
                    if (this.kejinList[i].userName == '阿鸡') {
                        if (this.kejinList[i].type == 0){
                            ajiVirtual += Number(this.kejinList[i].money);
                        } else {
                            ajiReality += Number(this.kejinList[i].money);
                        }
                    }
                    if (this.kejinList[i].userName == '拓哥') {
                        if (this.kejinList[i].type == 0){
                            tuogeVirtual += Number(this.kejinList[i].money);
                        } else {
                            tuogeReality += Number(this.kejinList[i].money);
                        }
                    }
                }
                this.allMoney = allMoney;
                this.allVirtual = allVirtual;
                this.allReality = allMoney - allVirtual;
                this.luxiVirtual = luxiVirtual;
                this.luxiReality = luxiReality;
                this.honggeVirtual = honggeVirtual;
                this.honggeReality = honggeReality;
                this.ajiVirtual = ajiVirtual;
                this.ajiReality = ajiReality;
                this.tuogeVirtual = tuogeVirtual;
                this.tuogeReality = tuogeReality;
                this.weekVirtual = weekVirtual;
                this.weekReality = weekReality;
            },
            init() {
                //Danger
                $('#dynamic-alert').click(function () {
                    swal.queue([{
                        title: '快捷查询本机IP',
                        confirmButtonColor: "#5438dc",
                        confirmButtonText: '查看我的公网IP',
                        text: '点击下面按钮获取你的公网IP',
                        showLoaderOnConfirm: true,
                        preConfirm: function () {
                            return new Promise(function (resolve) {
                                $.get('https://api.ipify.org?format=json')
                                    .done(function (data) {
                                        swal.insertQueueStep(data.ip)
                                        resolve()
                                    })
                            })
                        }
                    }]).catch(swal.noop)
                });

                let honggeAll = this.honggeVirtual + this.honggeReality;
                let luxiAll = this.luxiVirtual + this.luxiReality;
                let tuogeAll = this.tuogeVirtual + this.tuogeReality;
                let ajiAll = this.ajiVirtual + this.ajiReality;
                var options = {
                    series: [
                        {
                            name: "虚拟",
                            type: "column",
                            data: [this.honggeVirtual, this.luxiVirtual, this.tuogeVirtual, this.ajiVirtual]
                        },
                        {
                            name: "实体",
                            type: "column",
                            data: [this.honggeReality, this.luxiReality, this.tuogeReality, this.ajiReality]
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
                    series: [honggeAll, luxiAll, tuogeAll, ajiAll],
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
                    series: [parseFloat(this.weekVirtual/2500*100)],
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
                    series: [parseFloat(this.weekReality/2500*100)],
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
        },
        mounted() {
            this.calculateAll();
            this.init();
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
