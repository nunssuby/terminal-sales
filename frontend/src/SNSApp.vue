<template>
    <v-app id="inspire">
        <reservation-notification-app>
            <reservation-notification/>
        </reservation-notification-app>
        <div>
            <v-app-bar color="primary" app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word font uppercase"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                        >
                            <div style="line-height:100%;">≡</div>
                        </v-app-bar-nav-icon>
                    </span>
                </v-toolbar-title>
                <span v-if="urlPath!=null" 
                    class="mdi mdi-home" 
                    key="" 
                    to="/" 
                    @click="goHome()"
                    style="margin-left:10px; font-size:20px; cursor:pointer;"
		        ></span> 
                <v-spacer></v-spacer>
            </v-app-bar>
            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-list>
                    <v-list-item
                        class="px-2"
                        key="specComparations"
                        to="/specs/specComparations"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        단말기 스펙 비교
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="specs"
                        to="/specs/specs"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        단말기 스펙
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="orders"
                        to="/orders/orders"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        주문
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="retargettings"
                        to="/marketings/retargettings"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        리타겟팅
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="insuranceSubscriptions"
                        to="/insurances/insuranceSubscriptions"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        보험가입
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="salesData"
                        to="/salesdashboards/salesData"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        판매 데이터
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="salesStatuses"
                        to="/salesdashboards/salesStatuses"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        판매현황 대시보드
                    </v-list-item>
                    <v-list-item
                        class="px-2"
                        key="salesDashBoards"
                        to="/salesdashboards/salesDashBoards"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        판매 데이터 분석
                    </v-list-item>
                    <v-list-item
                        class="px-2"
                        key="users"
                        to="/users/users"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        사용자
                    </v-list-item>


                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container style="padding:0px;" v-if="urlPath" fluid>
                <router-view></router-view>
            </v-container>
            <v-container style="padding:0px;" v-else fluid>
                <div style="width:100%; position: relative;">
                    <v-img style="width:100%; height:200px;"
                        src="/image/main2.png"
                    ></v-img>
                    <div class="App-main-text-overlap"></div>
                    <div class="App-sub-text-overlap"></div>
                </div>
                <v-row class="pa-0 ma-0">
                    <v-col cols="12" sm="6" md="4" lg="3" class="pa-0 pa-0" v-for="(aggregate, index) in aggregate" :key="index">
                        <div class="pa-4" >
                            <v-card
                                :key="aggregate.key"
                                :to="aggregate.route"
                                @click="changeUrl()"
                                class="mx-auto main-card pa-4"
                                style="text-align: center; border-radius: 10px;"
                                outlined
                            >
                                <div class="d-flex justify-center" style="width:120px; height:120px; border-radius: 10px; margin: 0 auto; background-color:white;">
                                    <v-img style="width:100%; height:100%; object-fit:contain; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                </div>
                                <div style="text-align: center;">
                                    <h2 class="main-card-title">{{ aggregate.title }}</h2>
                                </div>
                            </v-card>
                        </div>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>

export default {
    name: "App",
    data: () => ({
        useComponent: "",
        drawer: true,
        components: [],
        sideBar: true,
        urlPath: null,
        flipped: [],
        ImageUrl: '',
        aggregate: [
            { 
                title: '단말기 스펙 비교', 
                description: 'SpecComparation을 관리하는 화면입니다.', 
                key: 'specComparations', 
                route: '/specs/specComparations',
                ImageUrl: '/image/Specification1.png',
            },
            { 
                title: '단말기 스펙', 
                description: 'Spec을 관리하는 화면입니다.', 
                key: 'specs', 
                route: '/specs/specs',
                ImageUrl: '/image/Specification2.png',
            },
            { 
                title: '주문', 
                description: 'Order을 관리하는 화면입니다.', 
                key: 'orders', 
                route: '/orders/orders',
                ImageUrl: '/image/order.png',
            },
            { 
                title: '리타겟팅', 
                description: 'Retargetting을 관리하는 화면입니다.', 
                key: 'retargettings', 
                route: '/marketings/retargettings',
                ImageUrl: '/image/retargettings.png',
            },
            { 
                title: '보험가입', 
                description: 'InsuranceSubscription을 관리하는 화면입니다.', 
                key: 'insuranceSubscriptions', 
                route: '/insurances/insuranceSubscriptions',
                ImageUrl: '/image/insurance.png',
            },
            { 
                title: '판매 데이터', 
                description: '판매 데이터를 관리하는 화면입니다.', 
                key: 'salesData', 
                route: '/salesdashboards/salesData',
                ImageUrl: '/image/sales-data.png',
            },
            { 
                title: '사용자', 
                description: '사용자를 관리하는 화면입니다.', 
                key: 'users', 
                route: '/users/users',
                ImageUrl: '/image/user.png',
            },
            { 
                title: '판매 현황',
                description: '판매 현황을 관리하는 화면입니다.', 
                key: 'salesStatuses', 
                route: '/salesdashboards/salesStatuses',
                ImageUrl: '/image/sales-status.png',
            },
            { 
                title: '판매 대시보드',
                description: 'SalesDashBoard을 관리하는 화면입니다.', 
                key: 'salesDashBoards', 
                route: '/salesdashboards/salesDashBoards',
                ImageUrl: '/image/sales-dashboard.png',
            },
        ],
    }),
    
    async created() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];

    },
    watch: {
        cards(newCards) {
            this.flipped = new Array(newCards.length).fill(false);
        },
    },

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },

    methods: {
        openSideBar(){
            this.sideBar = !this.sideBar
        },
        changeUrl() {
            var path = document.location.href.split("#/")
            this.urlPath = path[1];
            this.flipped.fill(false);
        },
        goHome() {
            this.urlPath = null;
        },
        flipCard(index) {
            this.$set(this.flipped, index, true);
        },
        unflipCard(index) {
            this.$set(this.flipped, index, false);
        },
    }
};
</script>
<style>
</style>
