import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SotietkiemEditComponent } from './sotietkiem-edit.component';

describe('SotietkiemEditComponent', () => {
  let component: SotietkiemEditComponent;
  let fixture: ComponentFixture<SotietkiemEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SotietkiemEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SotietkiemEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
