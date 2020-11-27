<template>
  <div class="container">
    <div class="row">
      <div id="chart" class="col"></div>
      <div id="chart2" class="col"></div>
    </div>
    <div class="row">
      <div id="chart3" class="col"></div>
      <div class="col"></div>
    </div>
  </div>
</template>

<script>
import ApexCharts from 'apexcharts';

export default {
  name: 'indexPage',
  data() {
    return {

    }
  },
  methods: {
    test(){
      console.log(111)
    }
  },
  mounted() {
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
    }, chart = new ApexCharts(document.querySelector("#chart"), options);
    chart.render();

    var options1 = {
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
    }

    var chart1 = new ApexCharts(document.querySelector("#chart2"), options1);
    chart1.render();
  }
}
</script>

<style scoped>

</style>
