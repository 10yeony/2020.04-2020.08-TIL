import Vue from "vue";
import VueRouter from "vue-router";
import CustomersList from "../components/CustomersList.vue";
import DetailCustomer from "../components/DetailCustomer.vue";
import SearchCustomers from "../components/SearchCustomers.vue";
import SearchCustomersById from "../components/SearchCustomersById.vue";
Vue.use(VueRouter);

const routes = [{
        path: "/",
        name: "customers",
        alias: "/customer",
        component: CustomersList //이렇게 쓰면 위에 import 해줘야 함
    },
    {
        path: "/about",
        name: "About",
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
            import ( /* webpackChunkName: "about" */ "../views/About.vue")
    }, ,
    {
        path: "/detailcustomer/:id",
        name: "detailcustomer",
        component: DetailCustomer,
        props: true, //중요함
    },
    {
        path: "/search",
        name: "search",
        component: SearchCustomers
    },
    {
        path: "/searchbyid",
        name: "searchbyid",
        component: SearchCustomersById
    }
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes
});

export default router;