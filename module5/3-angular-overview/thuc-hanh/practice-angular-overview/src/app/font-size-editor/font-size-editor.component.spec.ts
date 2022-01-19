import { async, ComponentFixture, TestBed } from '@angular/core/testing';

// @ts-ignore
import { FontSizeEditorComponent } from './font-size-editor.component';

describe('FontSizeEditorComponent', () => {
  let component: FontSizeEditorComponent;
  let fixture: ComponentFixture<FontSizeEditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FontSizeEditorComponent ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FontSizeEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
