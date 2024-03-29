import {customElement, bindable, inject} from 'aurelia-framework';
import {HttpClient} from 'aurelia-fetch-client';
import 'fetch';


@inject(HttpClient, Element)
@customElement('filters-category')

export class FiltersCategoryCustomElement {
  categories = [];
  
  @bindable categoryno = '';

  constructor(http,element){
    this.http = http;
    this.element = element;
  }
  
setCategory(event){
	this.categoryno = event.detail.value;
}

sortCategories (array) {

    var iarray = array.slice(0)
        .sort(
          function (a, b) {
          //console.log (a["order"] + " " + b["order"] + " " + (a["order"] - b["order"] ));
          return (b["order"] - a["order"] ) * -1  }
          );
    return iarray;
  } 

attached() {
    return Promise.all([
      this.http.fetch('/dashboard/categories').then(response => response.json()).then(categories => this.categories = this.sortCategories(categories))
    ]);
}


}