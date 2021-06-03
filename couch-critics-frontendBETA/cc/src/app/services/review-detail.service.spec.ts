import { TestBed } from '@angular/core/testing';

import { ReviewDetailService } from './review-detail.service';

describe('ReviewDetailService', () => {
  let service: ReviewDetailService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReviewDetailService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
