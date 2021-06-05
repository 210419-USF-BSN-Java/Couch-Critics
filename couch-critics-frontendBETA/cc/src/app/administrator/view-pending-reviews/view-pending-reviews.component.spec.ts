import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPendingReviewsComponent } from './view-pending-reviews.component';

describe('ViewPendingReviewsComponent', () => {
  let component: ViewPendingReviewsComponent;
  let fixture: ComponentFixture<ViewPendingReviewsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewPendingReviewsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPendingReviewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
