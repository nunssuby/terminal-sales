<template>

    <v-card outlined>
        <v-card-title>
            DetailSpec
        </v-card-title>

        <v-card-text>
            <Number label="Storage" v-model="value.storage" :editMode="editMode"/>
            <String label="Size" v-model="value.size" :editMode="editMode"/>
            <String label="Weight" v-model="value.weight" :editMode="editMode"/>
            <String label="Display" v-model="value.display" :editMode="editMode"/>
            <String label="Chip" v-model="value.chip" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'DetailSpec',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!Object.values(this.value)[0]) {
                this.$emit('input', {});
                this.newValue = {
                    'storage': '',
                    'size': '',
                    'weight': '',
                    'display': '',
                    'chip': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('storage' in this.value)) {
                    this.value.storage = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('size' in this.value)) {
                    this.value.size = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('weight' in this.value)) {
                    this.value.weight = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('display' in this.value)) {
                    this.value.display = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('chip' in this.value)) {
                    this.value.chip = '';
                }
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

