import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WarehousListComponent } from './warehous-list.component';

describe('WarehousListComponent', () => {
  let component: WarehousListComponent;
  let fixture: ComponentFixture<WarehousListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WarehousListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WarehousListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
