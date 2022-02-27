import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { XeListComponent } from './xe-list.component';

describe('XeListComponent', () => {
  let component: XeListComponent;
  let fixture: ComponentFixture<XeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ XeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(XeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
