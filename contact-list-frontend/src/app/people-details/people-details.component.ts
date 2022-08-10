import { Component, OnInit } from '@angular/core';
import {ImageFormatterComponent} from './image-formatter.component';
import {PeopleService} from './people-service.service';
import {take} from 'rxjs/operators';
import {People} from './people';

@Component({
  selector: 'app-people-details',
  templateUrl: './people-details.component.html',
  styleUrls: ['./people-details.component.css']
})
export class PeopleDetailsComponent implements OnInit {

  peopleName: any = '';

  constructor(private peopleService: PeopleService) { }

  columnDefs = [
    { headerName: 'ID', field: 'peopleID', width: 80 },
    {headerName: 'Name', field: 'peopleName', width: 300  },
    { headerName: 'URL',
      field: 'peopleImageURL',
      width: 200,
      sortable: false,
      autoHeight: true,
      cellRendererFramework: ImageFormatterComponent
    }
  ];

  rowData: People[] = [
    ];

  ngOnInit(): void {
    this.loadAllPeople();
  }

  loadAllPeople(): void{
    this.peopleService.getAllPeople().pipe(take(1)).subscribe(response => {
        this.rowData = response;
      }
    );
  }

  searchByName(): void{

    this.peopleService.searchPeople(this.peopleName).pipe(take(1)).subscribe(response => {
        console.log(response);
        this.rowData = response;
        console.log( this.rowData);
      }
    );
  }

  reset(): void{
    this.peopleName = '';
    this.loadAllPeople();
  }
}
