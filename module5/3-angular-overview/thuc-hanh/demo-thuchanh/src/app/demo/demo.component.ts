import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {
  myName: String = "Khoa";
  srcImage: String = "";
  myNumber: number = 0;

  constructor() {
  }

  ngOnInit(): void {
    if (this.myName == "Khoa") {
      this.srcImage = "https://teky.edu.vn/blog/wp-content/uploads/2021/07/ban-co-biet-angular-la-gi-khong.jpg";
      this.myNumber.valueOf()
    }
  }

  updateName() {
    this.myName="Trần Minh Khoa"
  }

}
