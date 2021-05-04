import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from '../../environments/environment';
import { Ficha } from 'app/models/ficha.model';
@Injectable({
  providedIn: 'root'
})
export class GeneradorFichaService {

  constructor(private http: HttpClient) { }

  //POST
  postFicha(ficha: Ficha) {
    this.http.post(environment.apiUrl + "docgen/", ficha).subscribe(data => {
      console.log(data);
    });
  }
}
