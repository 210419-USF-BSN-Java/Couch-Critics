import { TestBed } from '@angular/core/testing';

import { LogOutService } from './log-out.service';

describe('LogOutService', () => {
  let service: LogOutService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LogOutService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
