import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SotietkiemCreateComponent } from './sotietkiem-create.component';

describe('SotietkiemCreateComponent', () => {
  let component: SotietkiemCreateComponent;
  let fixture: ComponentFixture<SotietkiemCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SotietkiemCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SotietkiemCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
