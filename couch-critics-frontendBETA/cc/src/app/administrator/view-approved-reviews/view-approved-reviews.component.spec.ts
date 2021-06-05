import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewApprovedReviewsComponent } from './view-approved-reviews.component';

describe('ViewApprovedReviewsComponent', () => {
  let component: ViewApprovedReviewsComponent;
  let fixture: ComponentFixture<ViewApprovedReviewsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewApprovedReviewsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewApprovedReviewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
