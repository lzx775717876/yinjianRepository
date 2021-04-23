/*
Template Name: Nazox - Responsive Bootstrap 4 Admin Dashboard
Author: Themesdesign
Contact: themesdesign.in@gmail.com
File: Form element Js File
*/

var kejinRegistVue;

$(document).ready(function() {
    kejinRegistVue = new Vue({
        el: '#kejinRegist',
        data: {
            kejinWho: '',
            kejinItem: null,
            kejinType: false,
            kejinMoney: null,
            kejinTime: null,
            kejinRemark: null,
        },
        methods: {
            moneyCheck() {
                if (this.kejinMoney < 0) {
                    this.kejinMoney = 0;
                }
            },
            regist() {
                if (this.kejinMoney == null || this.kejinItem == null || this.kejinWho == '') {
                    Swal.fire(
                        {
                          title: "是不是漏了什么没填？",
                          text: '故事可以不说，日期可以不写，但是其他的不填我觉得不刑！',
                          icon: 'error',
                          confirmButtonColor: '#5438dc'
                        }
                    )
                    return;
                }
                let param = {
                    userName: this.kejinWho,
                    gameName: this.kejinItem,
                    type: this.kejinType ? 1 : 0,
                    money: this.kejinMoney,
                    remark: this.kejinRemark,
                }
                let thisMoney = this.kejinMoney;
                let kejinMessage = ''
                if (thisMoney >= 648) {
                    kejinMessage = '你完成了一次大师级氪金！'
                } else if (thisMoney >= 328 && thisMoney < 648) {
                    kejinMessage = '你完成了一次顶尖级氪金！'
                } else if (thisMoney >= 198 && thisMoney < 328) {
                    kejinMessage = '你完成了一次皇家级氪金！'
                } else if (thisMoney >= 128 && thisMoney < 198) {
                    kejinMessage = '你完成了一次达人级氪金！'
                } else if (thisMoney >= 68 && thisMoney < 128) {
                    kejinMessage = '你完成了一次老练的氪金！'
                } else if (thisMoney >= 30 && thisMoney < 68) {
                    kejinMessage = '你完成了一次佣兵级氪金！'
                } else if (thisMoney >= 6 && thisMoney < 30) {
                    kejinMessage = '你完成了一次初级氪金！'
                } else if (thisMoney < 6) {
                    kejinMessage = '你完成了一次新手氪金！'
                }
                if (thisMoney <= 220 && thisMoney >= 200) {
                    kejinMessage = '相当于一个战神底特律合集！'
                } else if (thisMoney == 518) {
                    kejinMessage = '相当于氪了一单扶她狗！'
                }
                $.ajax({
                    url: 'http://47.114.43.71:8080/buy/insertBuy',
                    type: "POST",
                    data: JSON.stringify(param),
                    async: false,
                    cache: false,
                    contentType: 'application/json;charset=utf-8',
                    success: function(result) {
                        Swal.fire(
                            {
                                title: '诶呀妈呀，成了!',
                                text: '介回你氪了' + thisMoney + '块钱!' + kejinMessage,
                                icon: 'success',
                                confirmButtonColor: '#5438dc',
                                cancelButtonColor: "#ff3d60"
                            }
                        ).then(function () {
                            window.location = "index.html";
                        })
                    },
                    error: function(xMLHttpRequest, textStatus, errorThrown) {
                        Swal.fire(
                            {
                                title: "服务器故障",
                                text: '肯定是出了点什么问题，至于这个问题是什么，那就需要经过一系列的探究才能发现了，然后至于这个问题该怎么解决，就得考虑这个问题是如何发生的，然后再进行相应的修改，修改完后还需要进行相应的测试，只有确定没有任何问题了以后，诶，就可以把这个不知道是什么问题的问题改好了，真是简单呢！',
                                icon: 'error',
                                confirmButtonColor: '#5438dc'
                            }
                        )
                    }
                });
            }
        },
        mounted() {

        },
        created() {
            let thisPage = this;

        }
    })
});