import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WarehousCreateComponent } from './warehous-create.component';

describe('WarehousCreateComponent', () => {
  let component: WarehousCreateComponent;
  let fixture: ComponentFixture<WarehousCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WarehousCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WarehousCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
