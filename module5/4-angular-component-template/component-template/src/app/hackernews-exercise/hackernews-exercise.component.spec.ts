import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HackernewsExerciseComponent } from './hackernews-exercise.component';

describe('HackernewsExerciseComponent', () => {
  let component: HackernewsExerciseComponent;
  let fixture: ComponentFixture<HackernewsExerciseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HackernewsExerciseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HackernewsExerciseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
