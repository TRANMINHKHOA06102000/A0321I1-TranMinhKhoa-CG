import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SotietkiemListComponent } from './sotietkiem-list.component';

describe('SotietkiemListComponent', () => {
  let component: SotietkiemListComponent;
  let fixture: ComponentFixture<SotietkiemListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SotietkiemListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SotietkiemListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
