import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PeopleDetailsComponent} from './people-details/people-details.component';

const appRoutes: Routes = [
  {
    path: 'session/login',
    component: PeopleDetailsComponent
  }];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule],
  providers: []
})

export class AppRoutingModule {
}
