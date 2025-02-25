<template>

    <v-data-table
        :headers="headers"
        :items="salesDashBoard"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'SalesDashBoardView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "phoneName", value: "phoneName" },
                { text: "phoneColor", value: "phoneColor" },
                { text: "gender", value: "gender" },
                { text: "region", value: "region" },
                { text: "price", value: "price" },
            ],
            salesDashBoard : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/salesDashBoards'))

            temp.data._embedded.salesDashBoards.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.salesDashBoard = temp.data._embedded.salesDashBoards;
        },
        methods: {
        }
    }
</script>

