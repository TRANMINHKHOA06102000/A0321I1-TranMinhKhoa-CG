import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstallBootstrapComponent } from './install-bootstrap.component';

describe('InstallBootstrapComponent', () => {
  let component: InstallBootstrapComponent;
  let fixture: ComponentFixture<InstallBootstrapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstallBootstrapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstallBootstrapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
