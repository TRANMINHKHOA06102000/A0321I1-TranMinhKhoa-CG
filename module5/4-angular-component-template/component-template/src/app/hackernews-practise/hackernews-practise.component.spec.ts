import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HackernewsPractiseComponent } from './hackernews-practise.component';

describe('HackernewsPractiseComponent', () => {
  let component: HackernewsPractiseComponent;
  let fixture: ComponentFixture<HackernewsPractiseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HackernewsPractiseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HackernewsPractiseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
