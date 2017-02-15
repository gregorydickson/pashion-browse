export class FilterValueConverter {
    toView(array, searchTerm, filterFunc, filterTerm, user) {

        if (!typeof(array)) return;
        if (!array) return;
        if (array == null) return;
        if (array == 'undefined') return;
        if (array == undefined) return;


        try {
            return array.filter((item) => {

                 // let matches = searchTerm && searchTerm.length > 0 ? filterFunc(searchTerm, item, filterTerm) : true;

                return filterFunc(searchTerm, item, filterTerm, user);
            });
        } catch (e) {console.log ("Exception thrown in filter: " + e);}

    }
}
