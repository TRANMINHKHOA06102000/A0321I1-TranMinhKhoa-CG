import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { XeEditComponent } from './xe-edit.component';

describe('XeEditComponent', () => {
  let component: XeEditComponent;
  let fixture: ComponentFixture<XeEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ XeEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(XeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
