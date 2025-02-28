
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import SpecSpecComparationManager from "./components/listers/SpecSpecComparationCards"
import SpecSpecComparationDetail from "./components/listers/SpecSpecComparationDetail"
import SpecSpecManager from "./components/listers/SpecSpecCards"
import SpecSpecDetail from "./components/listers/SpecSpecDetail"

import GetTerminalView from "./components/GetTerminalView"
import GetTerminalViewDetail from "./components/GetTerminalViewDetail"
import OrderOrderManager from "./components/listers/OrderOrderCards"
import OrderOrderDetail from "./components/listers/OrderOrderDetail"

import MarketingRetargettingManager from "./components/listers/MarketingRetargettingCards"
import MarketingRetargettingDetail from "./components/listers/MarketingRetargettingDetail"

import InsuranceInsuranceSubscriptionManager from "./components/listers/InsuranceInsuranceSubscriptionCards"
import InsuranceInsuranceSubscriptionDetail from "./components/listers/InsuranceInsuranceSubscriptionDetail"

import SalesdashboardSalesDataManager from "./components/listers/SalesdashboardSalesDataCards"
import SalesdashboardSalesDataDetail from "./components/listers/SalesdashboardSalesDataDetail"

import SalesStatusView from "./components/SalesStatusView"
import SalesStatusViewDetail from "./components/SalesStatusViewDetail"
import SalesDashBoardView from "./components/SalesDashBoardView"
import SalesDashBoardViewDetail from "./components/SalesDashBoardViewDetail"
import UserUserManager from "./components/listers/UserUserCards"
import UserUserDetail from "./components/listers/UserUserDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/specs/specComparations',
                name: 'SpecSpecComparationManager',
                component: SpecSpecComparationManager
            },
            {
                path: '/specs/specComparations/:id',
                name: 'SpecSpecComparationDetail',
                component: SpecSpecComparationDetail
            },
            {
                path: '/specs/specs',
                name: 'SpecSpecManager',
                component: SpecSpecManager
            },
            {
                path: '/specs/specs/:id',
                name: 'SpecSpecDetail',
                component: SpecSpecDetail
            },

            {
                path: '/specs/getTerminals',
                name: 'GetTerminalView',
                component: GetTerminalView
            },
            {
                path: '/specs/getTerminals/:id',
                name: 'GetTerminalViewDetail',
                component: GetTerminalViewDetail
            },
            {
                path: '/orders/orders',
                name: 'OrderOrderManager',
                component: OrderOrderManager
            },
            {
                path: '/orders/orders/:id',
                name: 'OrderOrderDetail',
                component: OrderOrderDetail
            },

            {
                path: '/marketings/retargettings',
                name: 'MarketingRetargettingManager',
                component: MarketingRetargettingManager
            },
            {
                path: '/marketings/retargettings/:id',
                name: 'MarketingRetargettingDetail',
                component: MarketingRetargettingDetail
            },

            {
                path: '/insurances/insuranceSubscriptions',
                name: 'InsuranceInsuranceSubscriptionManager',
                component: InsuranceInsuranceSubscriptionManager
            },
            {
                path: '/insurances/insuranceSubscriptions/:id',
                name: 'InsuranceInsuranceSubscriptionDetail',
                component: InsuranceInsuranceSubscriptionDetail
            },

            {
                path: '/salesdashboards/salesData',
                name: 'SalesdashboardSalesDataManager',
                component: SalesdashboardSalesDataManager
            },
            {
                path: '/salesdashboards/salesData/:id',
                name: 'SalesdashboardSalesDataDetail',
                component: SalesdashboardSalesDataDetail
            },

            {
                path: '/salesdashboards/salesStatuses',
                name: 'SalesStatusView',
                component: SalesStatusView
            },
            {
                path: '/salesdashboards/salesStatuses/:id',
                name: 'SalesStatusViewDetail',
                component: SalesStatusViewDetail
            },
            {
                path: '/salesdashboards/salesDashBoards',
                name: 'SalesDashBoardView',
                component: SalesDashBoardView
            },
            {
                path: '/salesdashboards/salesDashBoards/:id',
                name: 'SalesDashBoardViewDetail',
                component: SalesDashBoardViewDetail
            },
            {
                path: '/salesdashboards/salesDashBoards',
                name: 'SalesDashBoardView',
                component: SalesDashBoardView
            },
            {
                path: '/salesdashboards/salesDashBoards/:id',
                name: 'SalesDashBoardViewDetail',
                component: SalesDashBoardViewDetail
            },
            {
                path: '/users/users',
                name: 'UserUserManager',
                component: UserUserManager
            },
            {
                path: '/users/users/:id',
                name: 'UserUserDetail',
                component: UserUserDetail
            },



    ]
})
