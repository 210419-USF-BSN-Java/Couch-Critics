import { TestBed } from '@angular/core/testing';

import { ManagerServiceService } from './manager-service.service';

describe('ManagerServiceService', () => {
  let service: ManagerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ManagerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
