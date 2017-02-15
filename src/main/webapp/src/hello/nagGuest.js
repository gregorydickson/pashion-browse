import {DialogController} from 'aurelia-dialog';
import {HttpClient,json} from 'aurelia-fetch-client';
import 'fetch';
import {inject} from 'aurelia-framework';
import {DateFormat} from 'common/dateFormat';
//import {UserService} from 'services/userService.js'

@inject(DialogController)
export class NagGuest {
  


  constructor(controller){
    this.controller = controller;
   // this.userService = userService;
  }

  activate(){
  	// return this.user = this.userService.getUser().then(user => {this.user = user;})
  }
  
  close(){

    this.controller.close(false);
    
  }

  attached () {

  }

  signUp () {

    window.open("http://www.pashiontool.com/beta",'_blank');
    this.controller.close(true);

  }

}