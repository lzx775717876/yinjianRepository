/*
Template Name: Nazox - Responsive Bootstrap 4 Admin Dashboard
Author: Themesdesign
Contact: themesdesign.in@gmail.com
File: Dashboard Init Js File
*/

// Line-column chart

// var options = {
//     series: [{
//         name: '2020',
//         type: 'column',
//         data: [23, 42, 35, 27, 43, 22, 17, 31, 22, 22, 12, 16]
//     }, {
//         name: '2019',
//         type: 'line',
//         data: [23, 32, 27, 38, 27, 32, 27, 38, 22, 31, 21, 16]
//     }],
//     chart: {
//         height: 280,
//         type: 'line',
//         toolbar: {
//             show: false,
//         }
//     },
//     stroke: {
//         width: [0, 3],
//         curve: 'smooth'
//     },
//     plotOptions: {
//         bar: {
//             horizontal: false,
//             columnWidth: '20%',
//         },
//     },
//     dataLabels: {
//         enabled: false,
//     },
//
//     legend: {
//         show: false,
//     },
//     colors: ['#5664d2', '#1cbb8c'],
//     labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
// };

// var chart = new ApexCharts(document.querySelector("#line-column-chart"), options);
// chart.render();

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
