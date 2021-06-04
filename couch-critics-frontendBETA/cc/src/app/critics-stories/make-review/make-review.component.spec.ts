import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeReviewComponent } from './make-review.component';

describe('MakeReviewComponent', () => {
  let component: MakeReviewComponent;
  let fixture: ComponentFixture<MakeReviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MakeReviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
