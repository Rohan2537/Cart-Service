import { TestBed } from '@angular/core/testing';

import { ProductDataAccessServiceService } from './product-data-access-service.service';

describe('ProductDataAccessServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProductDataAccessServiceService = TestBed.get(ProductDataAccessServiceService);
    expect(service).toBeTruthy();
  });
});
