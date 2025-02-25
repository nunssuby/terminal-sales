<template>

    <v-card outlined>
        <v-card-title>
            SalesDashBoard # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="PhoneName" v-model="item.phoneName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PhoneColor" v-model="item.phoneColor" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Gender" v-model="item.gender" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Region" v-model="item.region" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Price" v-model="item.price" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'SalesDashBoardViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/salesDashBoards/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

