import {inject} from 'aurelia-framework';



export class App {

	user = {};

	constructor() {
	    

	  }

	configureRouter(config, router) {
    this.router = router;
    config.title = 'PASHION';
    config.map([

      { route: ['', '/'],       name: 'guestpage',       moduleId: 'guestpage' }
      
    ]);
  }

    activate() {
	    
	   
	  }
  
}
