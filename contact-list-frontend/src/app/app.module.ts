import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PeopleDetailsComponent } from './people-details/people-details.component';
import {AgGridModule} from 'ag-grid-angular';
import {ImageFormatterComponent} from './people-details/image-formatter.component';
import {PeopleService} from './people-details/people-service.service';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    PeopleDetailsComponent,
    ImageFormatterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AgGridModule.withComponents([ImageFormatterComponent]),
    HttpClientModule,
    FormsModule
  ],
  providers: [PeopleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
