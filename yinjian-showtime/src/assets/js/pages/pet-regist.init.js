/*
Template Name: Nazox - Responsive Bootstrap 4 Admin Dashboard
Author: Themesdesign
Contact: themesdesign.in@gmail.com
File: Form element Js File
*/

var petRegistVue;

$(document).ready(function() {
    petRegistVue = new Vue({
        el: '#petRegist',
        data: {
            petWho: '',
            petItem: null,
            petType: null,
            petMoney: null,
            petTime: null,
            petRemark: null,
            latestGame: null
        },
        methods: {
            moneyCheck() {
                if (this.petMoney < 0) {
                    this.petMoney = 0;
                }
            },
            pointGame(gameName) {
                this.petItem = gameName;
                $('.close').click();
            },
            regist() {
                if (this.petMoney == null || this.petItem == null || this.petWho == '') {
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
                    userName: this.petWho,
                    petItem: this.petItem,
                    itemType: this.petType,
                    money: this.petMoney,
                    remark: this.petRemark,
                    createTime: new Date(this.petTime)
                }
                let thisMoney = this.petMoney;
                let petMessage = ''
                if (thisMoney <= 220 && thisMoney >= 200) {
                    petMessage = '相当于一个战神底特律合集！'
                } else if (thisMoney <= 520 && thisMoney >= 515) {
                    petMessage = '相当于氪了一单扶她狗！'
                }
                $.ajax({
                    url: 'http://47.114.43.71:8080/pet/insertPetItem',
                    type: "POST",
                    data: JSON.stringify(param),
                    async: false,
                    cache: false,
                    contentType: 'application/json;charset=utf-8',
                    beforeSend: function (request) {
                        request.setRequestHeader('token', localStorage.getItem('token'));
                    },
                    success: function(result) {
                        Swal.fire(
                            {
                                title: '诶呀妈呀，成了!',
                                text: '介回你铲了' + thisMoney + '块钱的屎!' + petMessage,
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
            this.petWho = localStorage.getItem('userName');
            this.petTime = moment().format('YYYY-MM-DDTHH:mm')
        },
        created() {
            let thisPage = this;
            if (!localStorage.getItem("userName")) {
                Swal.fire(
                    {
                        title: "还没登录呢！",
                        text: '2秒后自动进入登录页面...',
                        icon: 'error',
                        confirmButtonColor: '#5438dc'
                    }
                )
                setTimeout(function () {
                    location.href = "auth-login.html";
                }, 2000);
            }
        }
    })
});