import { TestBed } from '@angular/core/testing';

import { CharityServiceService } from './charity-service.service';

describe('CharityServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CharityServiceService = TestBed.get(CharityServiceService);
    expect(service).toBeTruthy();
  });
});
