import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatRadioModule } from '@angular/material/radio';

@Component({
  selector: 'app-auth',
  standalone: true,
  imports: [CommonModule,FormsModule, MatFormFieldModule, MatInputModule,MatButtonModule,MatRadioModule],
  templateUrl: './auth.component.html',
  styleUrl: './auth.component.scss'
})
export class AuthComponent {

  isRegister: false = false;

  recipeItem:any={
    title:"",
    description:"",
    foodType:'',
    image:''

  }

  onSubmit(){
    console.log("values",this.recipeItem)
  }

}
